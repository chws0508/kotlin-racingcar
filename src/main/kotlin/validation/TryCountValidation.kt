package validation

class TryCountValidation {
    fun checkTryCount(tryCount: String?): ValidationResult {
        if (tryCount.isNullOrBlank()) return ValidationResult.Failure(INPUT_IS_EMPTY_ERROR_MESSAGE)
        if (!isTryCountInteger(tryCount)) return ValidationResult.Failure(TRY_COUNT_INTEGER_ERROR_MESSAGE)
        if (!isTryCountPositive(tryCount)) return ValidationResult.Failure(TRY_COUNT_POSITIVE_ERROR_MESSAGE)
        return ValidationResult.Success(tryCount)
    }

    fun isTryCountInteger(tryCount: String): Boolean {
        tryCount.toIntOrNull() ?: return false
        return true
    }

    fun isTryCountPositive(tryCount: String) = tryCount.toInt() < MINIMUM_POSITIVE_NUMBER

    companion object {
        const val MINIMUM_POSITIVE_NUMBER = 1
        const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
        const val TRY_COUNT_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력해 주세요"
        const val TRY_COUNT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수여야 합니다"
    }
}
