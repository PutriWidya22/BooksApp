package com.putri.booksapp.data.error

// class yang mengatur error fitur
sealed class Failure {
    object ServerError : Failure()
    abstract class FeatureFailure : Failure()
}