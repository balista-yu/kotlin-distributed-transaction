package com.sample.transaction.presentation.controller

import com.sample.transaction.usecase.NotDistributedTransactionUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sample")
@CrossOrigin
class NotDistributedTransactionController(
    private val useCase: NotDistributedTransactionUseCase,
) {
    @GetMapping("/not-distributed-transaction")
    operator fun invoke() {
        useCase()
    }
}
