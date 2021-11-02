package kosa.ion.sion.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kosa.ion.sion.dto.MembersDto;
import kosa.ion.sion.repository.MembersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private MembersRepository membersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));		
		MembersDto membersDto = membersRepository.findByMemberId(username).orElseThrow(() -> new NoSuchElementException());
		return new User(membersDto.getMemberId(), membersDto.getPassword(), roles);

	}
}
