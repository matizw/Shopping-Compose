package id.trainingdemo.sample.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import id.trainingdemo.sample.ui.component.ProgressProduct
import id.trainingdemo.sample.ui.screen.home.HomeViewModel
import id.trainingdemo.sample.ui.screen.search.section.SearchContent
import id.trainingdemo.core.R
import id.trainingdemo.core.data.UiState
import id.trainingdemo.core.data.model.ProductResponse
import id.trainingdemo.core.ui.component.molecules.SearchBar
import id.trainingdemo.core.ui.template.MainTemplate
import id.trainingdemo.core.ui.theme.Gray200

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
    navigateBack: () -> Unit,
) {
    val query = ""
    val focusRequester = remember { FocusRequester() }
    val uiStateProduct by remember { viewModel.uiStateProduct }.collectAsState()

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    MainTemplate(
        modifier = modifier,
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = navigateBack,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
                SearchBar(
                    query = query,
                    onQueryChange = viewModel::searchProductApiCall,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .focusRequester(focusRequester),
                )
            }
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxSize()
                    .background(Gray200)
            ) {
                when (uiStateProduct) {
                    is UiState.Loading -> {
                        viewModel.getProductsApiCall()
                        ProgressProduct()
                    }

                    is UiState.Success -> {
                        SearchContent(
                            modifier = modifier,
                            listProduct = (uiStateProduct as UiState.Success<ProductResponse>).data.products,
                            navigateToDetail = navigateToDetail,
                        )
                    }

                    is UiState.Error -> {
                        Text(text = stringResource(R.string.error_product), color = MaterialTheme.colors.onSurface)
                    }
                }
            }
        }
    )
}