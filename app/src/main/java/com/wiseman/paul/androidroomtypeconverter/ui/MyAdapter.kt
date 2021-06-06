package com.wiseman.paul.androidroomtypeconverter.ui
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wiseman.paul.androidroomtypeconverter.databinding.RowLayoutBinding
import com.wiseman.paul.androidroomtypeconverter.model.Person

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var person = emptyList<Person>()

    inner class MyViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            RowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return person.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.firstNameTxt.text = person[position].firstName
        holder.binding.lastNameTxt.text = person[position].lastName
        holder.binding.imageView.load(person[position].profilePhoto)
    }

    fun setData(person: List<Person>) {
        this.person = person
        notifyDataSetChanged()
    }
}