package com.mihahoni.dogsapp.data.model

data class BaseEntity<T : Any>(
    var status: String,
    var message: T
)