package com.enstagram.mapper;

import java.util.List;
import com.enstagram.model.EnstaAccount;

public interface EnstaMapper {

	public List<EnstaAccount> getList() throws Exception;
	public String create(EnstaAccount enstaAccount);
}