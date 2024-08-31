package com.example.torch.ui.theme.util
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager

class FlashlightController(private val context: Context) {

    private val cameraManager: CameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private val cameraId: String? = cameraManager.cameraIdList.find { id ->
        cameraManager.getCameraCharacteristics(id).get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
    }

    fun toggleFlashlight(enable: Boolean) {
        try {
            cameraId?.let {
                cameraManager.setTorchMode(it, enable)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    fun setFlashlightBrightness(level: Int) {
        // Not all devices support brightness adjustment for the flashlight.
        // Implement hardware-specific adjustments if necessary.
    }
}
