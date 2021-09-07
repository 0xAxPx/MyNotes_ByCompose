package com.peshale.mynotes.domain.model

import com.peshale.mynotes.data.database.model.ColorDbModel


/**
 * Model class for one Color
 */
data class ColorModel(
  val id: Long,
  val name: String,
  val hex: String
) {

  companion object {

    val DEFAULT = with(ColorDbModel.DEFAULT_COLOR) { ColorModel(id, name, hex) }
  }
}
