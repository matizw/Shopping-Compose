package id.trainingdemo.sample.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.trainingdemo.core.data.UiState
import id.trainingdemo.core.data.datasource.local.db.AppDatabase
import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity
import id.trainingdemo.core.data.repository.product.DbProductRepositoryImpl
import id.trainingdemo.core.domain.repository.product.DbProductRepository
import id.trainingdemo.core.domain.usecase.product.db.DeleteProductDbUseCase
import id.trainingdemo.core.domain.usecase.product.db.GetProductsDbUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val db: AppDatabase,
    private val getProductsDbUseCase: GetProductsDbUseCase = GetProductsDbUseCase(DbProductRepositoryImpl(db)),
    private val dbProductRepository: DbProductRepository,
) : ViewModel() {

    private val _uiStateDbProducts: MutableStateFlow<UiState<MutableList<ProductEntity>>> = MutableStateFlow(
        UiState.Loading)
    val uiStateDbProducts: StateFlow<UiState<MutableList<ProductEntity>>> = _uiStateDbProducts

    fun getProductsDb(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
        viewModelScope.launch(dispatcher) {
            try {
                getProductsDbUseCase.execute(Unit).catch {
                    _uiStateDbProducts.value = UiState.Error(it.message.toString())
                }.collect { product ->
                    _uiStateDbProducts.value = UiState.Success(product)
                }
            } catch (e: Exception) {
                _uiStateDbProducts.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun deleteProductDb(product: ProductEntity) {
        viewModelScope.launch {
            val intDelete = dbProductRepository.deleteProductDb(product)
            if (intDelete == 1) getProductsDb()
        }
    }
}