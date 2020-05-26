/*
 * UseCase.kt - app
 * Created by iamlordalvarado on 5/26/20 4:17 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:17 PM
 */

package com.bitso.challenge.core.domain.usecases

import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.core.extensions.Either
import kotlinx.coroutines.*

abstract class UseCase<in Params, out Result> where Result : Any {

    private var backgroundJob: Deferred<Either<Failure, Result>>? = null

    abstract suspend fun execute(params: Params): Either<Failure, Result>

    open operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        delayMillis: Long? = null,
        onResult: (Either<Failure, Result>) -> Unit = {}
    ) {
        backgroundJob = scope.async {
            delayMillis?.let {
                delay(it)
            }
            execute(params)
        }
        scope.launch { onResult(backgroundJob!!.await()) }
    }

    fun cancel() {
        if (backgroundJob != null && backgroundJob?.isCancelled == false) {
            backgroundJob?.cancel()
        }
    }
}
