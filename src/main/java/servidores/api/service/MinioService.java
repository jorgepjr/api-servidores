package servidores.api.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;

@Service
public class MinioService {
    @Value("${minio.bucket}")
    private String bucketName;

    @Autowired
    private MinioClient minioClient;

    public String uploadFoto(MultipartFile file, String nomeUnico) {
        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(
                PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(nomeUnico)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build()
            );

            return getUrlTemporaria(nomeUnico);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar imagem", e);
        }
    }

    public String getUrlTemporaria(String nomeArquivo) {
        try {
            return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(bucketName)
                    .object(nomeArquivo)
                    .expiry(60 * 5)
                    .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar URL", e);
        }
    }
}
