package com.example.vozdux.presenter.new_drone.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vozdux.R
import com.example.vozdux.presenter.generalComponents.CustomAlertDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConstructorTopBar(
    onBackIconClicked: () -> Unit
) {

    val alertDialogState = remember {
        mutableStateOf(false)
    }

    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp),
        title = {
            Text(
                text = stringResource(R.string.drone_constructor),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        navigationIcon = {
            IconButton(onClick = { alertDialogState.value = true }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.search),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            titleContentColor = MaterialTheme.colorScheme.secondary,
            actionIconContentColor = MaterialTheme.colorScheme.secondary
        )
    )

    if (alertDialogState.value) CustomAlertDialog(
        label = stringResource(id = R.string.are_you_sure),
        positive = { onBackIconClicked() },
        negative = { alertDialogState.value = false }
    )
}