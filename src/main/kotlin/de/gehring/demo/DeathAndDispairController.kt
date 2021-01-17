package de.gehring.demo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedInputStream

private val log = LoggerFactory.getLogger(DeathAndDispairController::class.java)

@RestController
class DeathAndDispairController {



    @PostMapping("/dispair")
    fun handleFileAndMetadata(
        @RequestParam fileOfDestruction: MultipartFile,
        @RequestParam filenameOfDestruction: String,
        @RequestParam associatedEmail: String,
        @RequestParam horribleCheckboxesOfDestruction: Array<String>
    ) {
        // Use demo-page.html in resources.
        log.info("The controller of death and dispair was executed with the following stuff:")
        log.info("Filename: $filenameOfDestruction")
        log.info("Associated Email: $associatedEmail")
        log.info("Checkbox values: ${horribleCheckboxesOfDestruction.joinToString()}")
        log.info("Also there's a file ("+fileOfDestruction.size+"B large).")
        val reader = BufferedInputStream(fileOfDestruction.inputStream)
        val bytes = reader.readNBytes(100)
        log.info("First 100 Bytes are (assuming UTF-8): \""+String(bytes)+"\"")
    }


}