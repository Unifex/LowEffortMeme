package nz.co.no.loweffortmeme.app.data

interface DataRepositoryContract {
    fun getTopText() : String
    fun getBottomText() : String
}