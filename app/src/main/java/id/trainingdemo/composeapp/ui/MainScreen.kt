package id.trainingdemo.composeapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.trainingdemo.sample.ui.navigation.BottomNav
import id.trainingdemo.core.ui.theme.ShoppingComposeTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    BottomNav(modifier, navController)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    ShoppingComposeTheme {
        MainScreen()
    }
}