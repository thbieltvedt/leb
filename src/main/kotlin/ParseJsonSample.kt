import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.core.JsonToken.*
import com.fasterxml.jackson.databind.MappingJsonFactory

import java.io.File

object ParseJsonSample {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
            //val f =
            val parser = MappingJsonFactory().createParser(File(args[0]))

            var current: JsonToken
            current = parser.nextToken()
            if (current != START_OBJECT && current != START_ARRAY) {
                println("Error: root should be object or array: quiting. Current: $current")
                return
            }
        
            while (parser.nextToken() != END_OBJECT) {
                val fieldName = parser.currentName
                // move from field name to field value
                println(fieldName + " -> " + parser.valueAsString)
                current = parser.nextToken()

//                if (fieldName == "organisasjonsnummer") {
//                    if (current == START_ARRAY) {
//                        // For each of the records in the array
//                        while (jp.nextToken() != JsonToken.END_ARRAY) {
//                            // read the record into a tree model,
//                            // this moves the parsing position to the end of it
//                            val node = jp.readValueAsTree<JsonNode>()
//                            // And now we have random access to everything in the object
//                            System.out.println("field1: " + node.get("field1").asText())
//                            System.out.println("field2: " + node.get("field2").asText())
//                        }
//                    } else {
//                        println("Error: records should be an array: skipping.")
//                        jp.skipChildren()
//                    }
//                } else {
//                    println("Unprocessed property: $fieldName")
//                    jp.skipChildren()
//                }
            }
    }
}