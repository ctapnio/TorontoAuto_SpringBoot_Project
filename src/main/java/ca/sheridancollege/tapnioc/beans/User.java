/*
 * Christian Tapnio
 * 991359879
 * Assignment 3
 * */
package ca.sheridancollege.tapnioc.beans;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
	private Long userId;
	@NonNull
	private String email;
	@NonNull
	private String encryptedPassword;
	@NonNull
	private Boolean enable;
}
