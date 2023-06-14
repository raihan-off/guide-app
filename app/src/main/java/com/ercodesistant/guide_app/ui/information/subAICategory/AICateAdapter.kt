package com.ercodesistant.guide_app.ui.information.subAICategory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ercodesistant.guide_app.databinding.ListWeblinkBinding
import com.ercodesistant.guide_app.model.WebLink
import android.content.Intent
import android.net.Uri


class AICateAdapter: RecyclerView.Adapter<AICateAdapter.ViewHolder>() {

    private val data = mutableListOf<WebLink>()

    fun updateData(newData: List<WebLink>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListWeblinkBinding
    ) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SuspiciousIndentation")
        fun bind(webLink: WebLink) = with(binding){
            namaTextView.text = webLink.nama_website

            root.setOnClickListener {

                val linkWebsite = webLink.link_website
                val uri = Uri.parse(linkWebsite)
                val intent = Intent(Intent.ACTION_VIEW, uri)

                    root.context.startActivity(intent)

                //val websiteLink = root.context.getString(webLink.link_website)
                //WebView.loadUrl(websiteLink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListWeblinkBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() : Int {
        return data.size
    }
}