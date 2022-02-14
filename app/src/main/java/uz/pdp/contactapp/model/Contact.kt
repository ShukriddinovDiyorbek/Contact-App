package uz.pdp.contactapp.model

class Contact{
    var id: Int?  = null
    var name: String? = null
    var number: String? = null

    constructor(name: String?, number: String?){
        this.name = name
        this.number = number
    }
    constructor(id:Int?,name: String?, number: String?){
        this.name = name
        this.number = number
    }
}