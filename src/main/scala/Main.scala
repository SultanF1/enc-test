import com.idealista.fpe.builder.FormatPreservingEncryptionBuilder
import com.idealista.fpe.component.functions.prf.{DefaultPseudoRandomFunction}
import com.idealista.fpe.config.{Alphabet, GenericDomain, GenericTransformations, LengthRange}



object Main {
  def main(args: Array[String]): Unit = {

    val keyWithMinimumSixteenBytes = "%C*F-JaNdRgUjXn2".getBytes()
    val alphabet:Alphabet = new Alphabet {
      override def availableCharacters(): Array[Char] = "0123456789".toCharArray
      override def radix(): Integer = 10
    }
    val formatPreservingEncryption = FormatPreservingEncryptionBuilder
      .ff1Implementation()
      .withDomain(new GenericDomain(alphabet, new GenericTransformations(alphabet.availableCharacters()), new GenericTransformations(alphabet.availableCharacters())))
      .withPseudoRandomFunction(new DefaultPseudoRandomFunction(keyWithMinimumSixteenBytes))
      .withLengthRange(new LengthRange(2, 5))
      .build();


    val plainText = "11"
    val tweak : Array[Byte] = "123".getBytes
    val cipher= formatPreservingEncryption.encrypt(plainText, tweak)

    println("Cipher: " + cipher, "decrypted: " + formatPreservingEncryption.decrypt(cipher, tweak))


  }
}