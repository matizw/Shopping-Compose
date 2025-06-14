package id.trainingdemo.sample.ui.screen.profile.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.trainingdemo.core.R

@Composable
fun ProfileContent() {
    Card(
        modifier = Modifier.size(160.dp),
        shape = CircleShape,
        elevation = 3.dp
    ) {
        Image(
            painterResource(R.drawable.user),
            contentDescription = stringResource(R.string.about_page),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.profile_signin),
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Light, fontSize = 18.sp, textAlign = TextAlign.Center
            ),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(16.dp))
       Button(onClick = {}) {
           Text(
               text = stringResource(id = R.string.profile_button)
           )
       }
    }
}