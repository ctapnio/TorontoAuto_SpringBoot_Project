/*
 * Created by: Christian Tapnio
 * Date: 10-12-2020
 * Spring-Boot Application with SQL Database
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
