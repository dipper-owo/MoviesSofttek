package com.jersson.diaz.moviessofttek.presentation.ui.login.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.moviessofttek.R
import com.jersson.diaz.moviessofttek.presentation.model.MoviesState
import com.jersson.diaz.moviessofttek.ui.theme.Blue
import com.jersson.diaz.moviessofttek.ui.theme.Green

@Composable
fun SuccessState(
    validateUser: Function<MoviesState.User, Unit>,
){
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = user,
        label = {
            Text(text = stringResource(id = R.string.login_user))
        },
        onValueChange = {
            user = it
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Blue,
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        label = {
            Text(text = stringResource(id = R.string.login_password))
        },
        onValueChange = {
            password = it
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Blue,
        )
    )
    Spacer(modifier = Modifier.height(18.dp))
    Button(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            validateUser.apply(
                MoviesState.User(
                    user = user,
                    password = password,
                )
            )
        }
    ) {
        Text(text = stringResource(id = R.string.login_enter))
    }
}