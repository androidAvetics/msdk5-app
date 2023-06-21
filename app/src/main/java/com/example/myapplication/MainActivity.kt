package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dji.v5.common.error.IDJIError
import dji.v5.common.register.DJISDKInitEvent
import dji.v5.manager.SDKManager
import dji.v5.manager.interfaces.SDKManagerCallback

class MainActivity : AppCompatActivity() {
    private val TAG = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerApp()
    }
    private fun registerApp()
    {
        SDKManager.getInstance().init(this,object:SDKManagerCallback{
            override fun onInitProcess(event: DJISDKInitEvent?, totalProcess: Int) {
                Log.i(TAG, "onInitProcess: ")
                if (event == DJISDKInitEvent.INITIALIZE_COMPLETE) {
                    SDKManager.getInstance().registerApp()
                }
            }
            override fun onRegisterSuccess() {
                Log.i(TAG, "onRegisterSuccess: ")
            }
            override fun onRegisterFailure(error: IDJIError?) {
                Log.i(TAG, "onRegisterFailure: ")
            }
            override fun onProductConnect(productId: Int)
            {
                Log.i(TAG, "onProductConnect: ")
            }
            override fun onProductDisconnect(productId: Int) {
                Log.i(TAG, "onProductDisconnect: ")
            }
            override fun onProductChanged(productId: Int)
            {
                Log.i(TAG, "onProductChanged: ")
            }
            override fun
                    onDatabaseDownloadProgress(current: Long, total: Long) {
                Log.i(TAG, "onDatabaseDownloadProgress: ${current/total}")
            }
        })
    }
}
