package kosa.ion.sion.repository;


import kosa.ion.sion.dto.FileTestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "fileTestdto", path="fileTestdto")
@CrossOrigin("*")
public interface FileTestRepository extends JpaRepository<FileTestDto, Long> {
}
