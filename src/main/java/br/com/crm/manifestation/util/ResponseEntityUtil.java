package br.com.crm.manifestation.util;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author DavidBen
 *
 */
public class ResponseEntityUtil {

	public static final ResponseEntity<?> created(String path, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{"+path+"}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public static final ResponseEntity<Void> noContent() {
		return ResponseEntity.noContent().build();
	}
	
	public static final ResponseEntity<?> ok(Object body) {
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	public static final ResponseEntity<?> ok(Object body, long timeout) {
		CacheControl cacheControl  = CacheControl.maxAge(timeout, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(body);
	}
	
	public static final ResponseEntity<?> notFound(Object body) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
	public static final ResponseEntity<?> conflict(Object body) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}
	
}
