package mzumot.plantsapp.backend.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GalleryController {

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("imgs/" + id + ".png");

        // Read the input stream into a byte array
        byte[] bytes = readInputStream(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        return buffer.toByteArray();
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String name) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("imgs/" + name + ".png");
        System.out.println("image url " + imgFile);
        // Read the input stream into a byte array
        byte[] bytes = readInputStream(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }

}