package com.example.mymessages

class contact{
    var img:Int?=null
    var name:String?=null
    var artist:String?=null
    var heart:Boolean?=false
    constructor(img:Int, name:String, artist:String, heart:Boolean = false ){
        this.img = img
        this.name = name
        this.artist = artist
        this.heart = heart
    }
}