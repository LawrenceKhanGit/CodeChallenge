package com.location.codechallenge

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.location.codechallenge.network.models.ApiSite
import com.location.codechallenge.network.models.Constants
import com.location.codechallenge.viewmodel.MapsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    private val viewModel : MapsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        (supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)?.let {
            it.getMapAsync(this)
        }

        setupObserver()
    }

    private fun setupObserver() {
        viewModel?.liveLocation?.observe(this, Observer<List<ApiSite>> { location ->
            for (i in location.indices) {
                val lat: Double = location[i].lat.toDouble()
                val long: Double = location[i].long.toDouble()
                val name: String = location[i].name
                mMap!!.addMarker(
                    MarkerOptions()
                        .position(LatLng(lat, long))
                        .title(name)
                )
            }
        })
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(LatLng(Constants.lat, Constants.lng)))

    }
}