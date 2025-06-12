package id.trainingdemo.sample.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import id.trainingdemo.sample.ui.component.ProgressProduct
import id.trainingdemo.sample.ui.screen.home.section.HomeContent
import id.trainingdemo.core.R
import id.trainingdemo.core.data.UiState
import id.trainingdemo.core.ui.component.molecules.SearchBar
import id.trainingdemo.core.ui.template.MainTemplate
import id.trainingdemo.core.ui.theme.Gray200


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
    navigateToSearch: () -> Unit,
) {
    MainTemplate(
        modifier = modifier,
        topBar = {
            SearchBar(
                query = "",
                onQueryChange = {},
                modifier = Modifier.background(MaterialTheme.colors.primary),
                isEnabled = false,
                onSearchClicked = { navigateToSearch() }
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxSize()
                    .background(Gray200)
            ) {
                viewModel.uiStateProduct.collectAsState(initial = UiState.Loading).value.let { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            viewModel.getProductsApiCall()
                            ProgressProduct()
                        }

                        is UiState.Success -> {
                            HomeContent(
                                modifier = modifier,
                                listProduct = uiState.data.products,
                                navigateToDetail = navigateToDetail,
                            )
                        }

                        is UiState.Error -> {
                            Text(text = stringResource(R.string.error_product), color = MaterialTheme.colors.onSurface)
                        }
                    }
                }
            }
        })
}