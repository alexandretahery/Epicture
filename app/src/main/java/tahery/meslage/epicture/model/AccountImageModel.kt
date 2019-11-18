package tahery.meslage.epicture.model

data class AccountImageModel (
    var data : Array<ImageModel>,
    var success : Boolean = false,
    var status : String
)
