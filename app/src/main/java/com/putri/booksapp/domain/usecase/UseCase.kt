package com.putri.booksapp.domain.usecase

import arrow.core.Either
import com.putri.booksapp.data.error.Failure
import kotlinx.coroutines.*

// membuat abstract class dengan deklarasi variabel mainJob, dan uiScope.
abstract class UseCase<out Type, in Params> where Type : Any {

    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) =
        uiScope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    fun cancel() {
        mainJob.cancel()
    }
}