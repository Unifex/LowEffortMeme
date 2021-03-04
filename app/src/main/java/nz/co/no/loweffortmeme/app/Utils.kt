package nz.co.no.loweffortmeme.app

import android.text.SpannedString
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.underline

/**
 * Here's how this method works
 *
 * It takes a string receiver and splits it twice resulting in List<List<String>>
 *
 * Treat the first dimension as bold. If the index is odd, we're between **delim** and text should be bold
 *
 * Treat the second dimension as underline. If the index is odd, we're between __delim__ and text should be underlined
 *
 * This method is really basic, and as such has some flaws
 *
 *   I **Want** to parse __this__ otherword
 *   [I ,Want, to parse __this__ otherword] <- First split result
 *   [[I] ,[Want],[ to parse ,this, otherword]] <- Second split result
 *   This will be handled correctly
 *
 *   this is **bold and __underlined__**
 *   [this is ,bold and __underlined__]
 *   [[this is ],[bold and ,underlined,]]
 *   This will be handled correctly but will add an empty char to the end. Shouldn't affect anything
 *   but not exactly pretty
 *
 *    **__bold__**
 *   [,__bold__,]
 *   [[],[,bold,], []]
 *   This will be handled correctly but will add an empty char to the end. Shouldn't affect anything
 *   but not exactly pretty
 *
 *   __something something **bold**__
 *   [__something something ,bold,__]
 *   [[,something something ],[bold],[,]]
 *   This does weird things and isn't supported
 *
 *   TL;DR: Stay away from nesting. If nesting is needed, implement a proper solution
 */
fun String.dumbParseMarkdown(): SpannedString {
    val split = trim().split("**").map { it.split("__") }

    return buildSpannedString {
        val handleUnderline = { ind: Int, item: String ->
            if (ind % 2 == 0) {
                append(item)
            } else {
                underline {
                    append(item)
                }
            }
            Unit
        }

        split.forEachIndexed { ind, item: List<String> ->
            if (ind % 2 == 0) {
                item.forEachIndexed(handleUnderline)
            } else {
                bold {
                    item.forEachIndexed(handleUnderline)
                }
            }
            Unit
        }

    }
}