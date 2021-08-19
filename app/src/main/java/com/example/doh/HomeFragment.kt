package com.example.doh

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doh.databinding.FragmentHomeBinding
import com.example.doh.models.smsData
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var messages: MutableList<smsData>
    private val requestReadSMS: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = requireContext()?.applicationContext
        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            shouldShowRequestPermissionRationale(android.Manifest.permission.READ_SMS)
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.READ_SMS),
                requestReadSMS
            )
        } else {
            Toast.makeText(context, "SMS permission granted", Toast.LENGTH_SHORT).show()
//            getSmsByFilterAndSelection("inbox",null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        binding.addFinanceEntity.setOnClickListener {
            showAddEntityDialog()
        }
        getSmsByFilterAndSelection("inbox", null)
        return binding.root
    }

    private fun showAddEntityDialog() {
        findNavController().navigate(R.id.action_homeFragment_to_addEntityDialogFragment)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == requestReadSMS)
            getSmsByFilterAndSelection("inbox", null)

    }

    private fun getSmsByFilterAndSelection(filter: String, selection: String?) {
        val cursor = context?.contentResolver
            ?.query(
                Uri.parse("content://sms/$filter"),
                null,
                selection,
                null,
                null
            )

        if (cursor?.moveToFirst() == true) {

            val addressId = cursor.getColumnIndex("address")
            val dateId = cursor.getColumnIndex("date")
            val messageId = cursor.getColumnIndex("body")

            do {
                val smsData = smsData(
                    cursor.getString(addressId),
                    Date(cursor.getString(dateId).toLong()).toString(),
                    cursor.getString(messageId)
                )
                messages.add(smsData)
            } while (cursor.moveToNext())
        }
    }

}