/**
 * Breaking Bad mobile application
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.example.mobillabor.network.dto


/**
 *
 * @param quoteId
 * @param quote
 * @param author
 */
data class QuoteResponse(
    val quoteId: Int,
    val quote: String,
    val author: String
)