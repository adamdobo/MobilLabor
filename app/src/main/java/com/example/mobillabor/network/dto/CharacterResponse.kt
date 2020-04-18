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
 * @param charId 
 * @param name 
 * @param birthday 
 * @param occupation 
 * @param img 
 * @param status 
 * @param nickname 
 * @param appearance 
 * @param portrayedBy 
 */
data class CharacterResponse (
    val charId: Int,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: List<Int>,
    val portrayedBy: String

) {
}