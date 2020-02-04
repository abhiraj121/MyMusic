package com.example.mymessages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_ticket.view.*


class MainActivity : AppCompatActivity() {

    var contactNames = ArrayList<contact>()
    var adapter: contactAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactNames.add(contact(R.drawable.bajrangdal,"Bajrangdal Anthem","RSS/ABVP",true))
        contactNames.add(contact(R.drawable.kai,"Shubharambh","Divya Kumar"))
        contactNames.add(contact(R.drawable.chaita,"Chaita ki Chaitwal","Amit Sagar"))
        contactNames.add(contact(R.drawable.nochami,"Nauchami Narayana","Narendra Singh Negi",true))
        contactNames.add(contact(R.drawable.personalities,"Mixed Personalities","YNW Melly ft. Kanye West"))
        contactNames.add(contact(R.drawable.ghung,"Ghungroo","Arjit Singh"))
        contactNames.add(contact(R.drawable.randi,"Randi Babu Randi","A.R. Rehman",true))

        adapter = contactAdapter(this,contactNames)
        MyListView.adapter = adapter
    }

    fun delete(index:Int) {
        contactNames.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index: Int){
        contactNames.add(contactNames[index])
        adapter!!.notifyDataSetChanged()
    }

    inner class contactAdapter : BaseAdapter {

        var contactNames:ArrayList<contact>
        var context:Context?= null
        constructor(context:Context, contactNames: ArrayList<contact>):super(){
            this.contactNames = contactNames
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var newcontact = contactNames[position]
            if(newcontact.heart==false) {
                var inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myview = inflater.inflate(R.layout.contact_ticket, null)
                myview.ArtistName.text = newcontact.artist!!
                myview.SongName.text = newcontact.name!!
                myview.imageView.setImageResource(newcontact.img!!)

                myview.clicklayout.setOnClickListener(View.OnClickListener {
                    var intent = Intent(context,SongInfo::class.java)
                    intent.putExtra("name",newcontact.name)
                    intent.putExtra("artist",newcontact.artist)
                    intent.putExtra("heart", newcontact.heart!!)
                    intent.putExtra("image",newcontact.img!!)
                    context!!.startActivity(intent)
                })
                myview.clicklayout.setOnLongClickListener {
                    delete(position)
                    true
                }

                return myview
            }else{
                var inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myview = inflater.inflate(R.layout.contact_favorite, null)
                myview.ArtistName.text = newcontact.artist!!
                myview.SongName.text = newcontact.name!!
                myview.imageView.setImageResource(newcontact.img!!)

                myview.clicklayout.setOnClickListener(View.OnClickListener {
                    var intent = Intent(context,SongInfo::class.java)
                    intent.putExtra("name",newcontact.name)
                    intent.putExtra("artist",newcontact.artist)
                    intent.putExtra("heart", newcontact.heart!!)
                    intent.putExtra("image",newcontact.img!!)
                    context!!.startActivity(intent)
                })
                myview.clicklayout.setOnLongClickListener {
                    delete(position)
                    true
                }

                return myview
            }
        }

        override fun getItem(position: Int): Any {
            return contactNames[position]
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()

        }

        override fun getCount(): Int {
            return contactNames.size
        }

    }
}
