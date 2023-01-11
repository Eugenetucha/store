/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectroTypePK implements Comparable<ElectroTypePK>, Serializable {

	public long electroTypeId;
	public long companyId;

	public ElectroTypePK() {
	}

	public ElectroTypePK(long electroTypeId, long companyId) {
		this.electroTypeId = electroTypeId;
		this.companyId = companyId;
	}

	public long getElectroTypeId() {
		return electroTypeId;
	}

	public void setElectroTypeId(long electroTypeId) {
		this.electroTypeId = electroTypeId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	@Override
	public int compareTo(ElectroTypePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (electroTypeId < pk.electroTypeId) {
			value = -1;
		}
		else if (electroTypeId > pk.electroTypeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (companyId < pk.companyId) {
			value = -1;
		}
		else if (companyId > pk.companyId) {
			value = 1;
		}
		else {
			value = 0;
		}

		return value;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroTypePK)) {
			return false;
		}

		ElectroTypePK pk = (ElectroTypePK)object;

		return (electroTypeId == pk.electroTypeId) &&
				(companyId == pk.companyId);
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, electroTypeId);
		hashCode = HashUtil.hash(hashCode, companyId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("electroTypeId=");

		sb.append(electroTypeId);
		sb.append(", companyId=");

		sb.append(companyId);

		sb.append("}");

		return sb.toString();
	}

}