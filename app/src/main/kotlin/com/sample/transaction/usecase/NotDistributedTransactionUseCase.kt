package com.sample.transaction.usecase

import com.sample.transaction.core.domain.repository.NotDistributedTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class NotDistributedTransactionUseCase(
    private val repository: NotDistributedTransactionRepository,
) {
    operator fun invoke() {
        repository.register()
    }
}
