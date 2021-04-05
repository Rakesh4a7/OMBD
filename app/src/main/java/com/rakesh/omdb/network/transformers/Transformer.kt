package com.rakesh.omdb.network.transformers

abstract class Transformer<ResponseDaoClass, LocalDataClass> {
    abstract fun transform(responseDao:ResponseDaoClass):LocalDataClass
}