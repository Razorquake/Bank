package com.example.bank.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bank.domain.repo.Details

@Composable
fun DetailsScreen(details: Details) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .verticalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceEvenly
        ){
        details.uid?.let {
            TextField(
                label = { Text("UID") },
                value = it,
                onValueChange = {},
                enabled = details.uid.isEmpty(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
            )
        }
        details.name?.let {
            TextField(
                label = { Text("Name") },
                value = it,
                onValueChange = {},
                enabled = details.name.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.gender?.let {
            TextField(
                label = {Text("Gender")},
                value = it,
                onValueChange = {},
                enabled = details.gender.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.yob?.let {
            TextField(
                label = {Text("Year of Birth")},
                value = it,
                onValueChange = {},
                enabled = details.yob.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.co?.let {
            TextField(
                label = {Text("Son of")},
                value = it,
                onValueChange = {},
                enabled = details.co.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.house?.let {
            TextField(
                label = {Text("House No.")},
                value = it,
                onValueChange = {},
                enabled = details.house.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.street?.let {
            TextField(
                label = {Text("Street")},
                value = it,
                onValueChange = {},
                enabled = details.street.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.vtc?.let {
            TextField(
                label = {Text("Village/Town/City")},
                value = it,
                onValueChange = {},
                enabled = details.vtc.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.po?.let {
            TextField(
                label = {Text("Post Office")},
                value = it,
                onValueChange = {},
                enabled = details.po.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.dist?.let {
            TextField(
                label = {Text("District")},
                value = it,
                onValueChange = {},
                enabled = details.dist.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.subdist?.let {
            TextField(
                label = {Text("Sub-District")},
                value = it,
                onValueChange = {},
                enabled = details.subdist.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.state?.let {
            TextField(
                label = {Text("State")},
                value = it,
                onValueChange = {},
                enabled = details.state.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.pc?.let {
            TextField(
                label = {Text("Postal Code")},
                value = it,
                onValueChange = {},
                enabled = details.pc.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        details.dob?.let {
            TextField(
                label = {Text("Date of Birth")},
                value = it,
                onValueChange = {},
                enabled = details.dob.isEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Button(onClick = {  }) {
            Text(text ="Save")
        }
    }
}