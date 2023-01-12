/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.service.model.Electronics;
import com.service.model.impl.ElectronicsImpl;
import com.service.service.base.ElectronicsLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.service.model.Electronics",
        service = AopService.class
)
public class ElectronicsLocalServiceImpl
        extends ElectronicsLocalServiceBaseImpl {
    public Electronics addElectronics(boolean archive,String name, Long etype, Long price, int electronics_count, boolean inStock, String description) {
        Electronics electronics = new ElectronicsImpl();
        electronics.setArchive(archive);
        electronics.setName(name);
        electronics.setElectroTypeId(etype);
        electronics.setPrice(price);
        electronics.setElectronics_count(electronics_count);
        electronics.setInStock(inStock);
        electronics.setDescription(description);
        return super.addElectronics(electronics);
    }
    public Electronics addElectronicsWithId(Long id, String name ,Long etype,Long price, int electronics_count,boolean inStock,boolean archive, String description) {
        Electronics electronics = new ElectronicsImpl();
        electronics.setElectronicsId(id);
        electronics.setArchive(archive);
        electronics.setName(name);
        electronics.setPrice(price);
        electronics.setElectronics_count(electronics_count);
        electronics.setInStock(inStock);
        electronics.setDescription(description);
        return super.addElectronics(electronics);
    }

    public Electronics updateElectronics(boolean archive, String name, Long etype,Long price, int electronics_count, boolean inStock, String description) {
        Electronics electronics = new ElectronicsImpl();
        electronics.setElectroTypeId(etype);
        electronics.setArchive(archive);
        electronics.setName(name);
        electronics.setPrice(price);
        electronics.setElectronics_count(electronics_count);
        electronics.setInStock(inStock);
        electronics.setDescription(description);
        return super.updateElectronics(electronics);
    }

    @Override
    public Electronics deleteElectronics(long ElectronicsId) throws PortalException {
        return super.deleteElectronics(ElectronicsId);
    }

    @Override
    public int getElectronicsesCount() {
        return super.getElectronicsesCount();
    }
}