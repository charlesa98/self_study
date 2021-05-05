package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch>{

	public LibraryBranchDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_library_branch (branchId, branchName, branchAddress) VALUES (?, ?, ?)",
				new Object[] {branch.getBranchID(), branch.getBranchName(), branch.getBranchAddress()});
	}
	
	public void updateLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?", 
				new Object[] {branch.getBranchName(), branch.getBranchAddress(), branch.getBranchID()});
	}
	
	public void updateLibraryBranchName(LibraryBranch branch) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_library_branch set branchName = ? where branchId = ?", 
				new Object[] {branch.getBranchName(), branch.getBranchID()});
	}
	
	public void updateLibraryBranchAddress(LibraryBranch branch) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_library_branch set branchAddress = ? where branchId = ?", 
				new Object[] {branch.getBranchAddress(), branch.getBranchID()});
	}
	
	public void deleteLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_library_branch where branchId = ?", new Object[] {branch.getBranchID()});
	}
	
	public List<LibraryBranch> getAllLibraryBranchs() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_library_branch", null);	
	}
	
	@Override
	public List<LibraryBranch> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<LibraryBranch> branchs = new ArrayList<>();
		
		while(rs.next())
		{
			LibraryBranch branch = new LibraryBranch();
			branch.setBranchID(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			branchs.add(branch);
		}
		return branchs;
	}
}

