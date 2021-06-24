package com.ocanha.viewbindingtutorialcomkotlin.recyclerviewexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocanha.viewbindingtutorialcomkotlin.databinding.ActivityRecyclerViewViewBindingExampleBinding

class RecyclerViewViewBindingExampleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerViewViewBindingExampleBinding
    private lateinit var liveAdapter: LiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityRecyclerViewViewBindingExampleBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

    }

    override fun onStart() {
        super.onStart()

        initRecyclerView()
        addDataSource()
    }

    private fun initRecyclerView() {

        liveAdapter = LiveAdapter{live ->
            openLink(live.link)
        }

        this.binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewViewBindingExampleActivity)
            adapter = liveAdapter
        }

    }

    private fun openLink(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)

    }

    private fun addDataSource() {

        val dataSource = DataSource.createDataSet()
        liveAdapter.setList(dataSource)

    }

}