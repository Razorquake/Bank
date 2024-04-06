package com.example.bank.data.repo

import android.util.Xml
import com.example.bank.domain.repo.Details
import com.example.bank.domain.repo.MainRepo
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.StringReader
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val scanner: GmsBarcodeScanner
) : MainRepo{
    override fun startScanning(): Flow<Details> {
        return callbackFlow {
            scanner.startScan()
                .addOnSuccessListener {
                    launch {
                        val details = getDetails(it)
                        send(details)

                    }
                }
                .addOnFailureListener{
                    it.printStackTrace()
                }
            awaitClose()
        }
    }
    private fun getDetails(barcode: Barcode): Details {
        val xmlData = barcode.rawValue
        val parser = Xml.newPullParser()
        try {
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(StringReader(xmlData))
            parser.nextTag()
            return readData(parser)
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Details("","","","","","","","","","","","","","")
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readData(parser: XmlPullParser): Details {
        parser.require(XmlPullParser.START_TAG, null, "PrintLetterBarcodeData")
        val uid = parser.getAttributeValue(null, "uid")
        val name = parser.getAttributeValue(null, "name")
        val gender = parser.getAttributeValue(null, "gender")
        val yob = parser.getAttributeValue(null, "yob")
        val co = parser.getAttributeValue(null, "co")
        val house = parser.getAttributeValue(null, "house")
        val street = parser.getAttributeValue(null, "street")
        val vtc = parser.getAttributeValue(null, "vtc")
        val po = parser.getAttributeValue(null, "po")
        val dist = parser.getAttributeValue(null, "dist")
        val subdist = parser.getAttributeValue(null, "subdist")
        val state = parser.getAttributeValue(null, "state")
        val pc = parser.getAttributeValue(null, "pc")
        val dob = parser.getAttributeValue(null, "dob")
        return Details(uid, name, gender, yob, co, house, street, vtc, po, dist, subdist, state, pc, dob)
    }
}