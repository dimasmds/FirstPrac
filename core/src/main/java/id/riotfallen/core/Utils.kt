package id.riotfallen.core

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class Utils {
    class Currency{
        fun doubleToCurrencyFormat(value: Double) : String {
            val format = DecimalFormat.getCurrencyInstance() as DecimalFormat
            format.decimalFormatSymbols = indonesianLocaleNumberFormat()
            return format.format(value)
        }

        private fun indonesianLocaleNumberFormat() : DecimalFormatSymbols {
            val formatRp = DecimalFormatSymbols()

            formatRp.currencySymbol = "Rp. "
            formatRp.monetaryDecimalSeparator = ','
            formatRp.groupingSeparator = '.'

            return formatRp
        }
    }
}