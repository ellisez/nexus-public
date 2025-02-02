/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.internal.datastore

import javax.inject.Named
import javax.inject.Singleton

import org.sonatype.nexus.security.config.CPrivilege
import org.sonatype.nexus.security.config.MemorySecurityConfiguration
import org.sonatype.nexus.security.config.SecurityContributor

/**
 * DataStore security configuration.
 *
 * @since 3.next
 */
@Named
@Singleton
class DataStoreSecurityContributor
    implements SecurityContributor
{
  @Override
  MemorySecurityConfiguration getContribution() {
    return new MemorySecurityConfiguration(
        privileges: [
            new CPrivilege(
                id: 'nx-datastores-all',
                description: 'All permissions for data stores',
                type: 'application',
                properties: [
                    domain : 'datastores',
                    actions: '*'
                ]
            ),
            new CPrivilege(
                id: 'nx-datastores-create',
                description: 'Create permission for data stores',
                type: 'application',
                properties: [
                    domain : 'datastores',
                    actions: 'create,read'
                ]
            ),
            new CPrivilege(
                id: 'nx-datastores-read',
                description: 'Read permission for data stores',
                type: 'application',
                properties: [
                    domain : 'datastores',
                    actions: 'read'
                ]
            ),
            new CPrivilege(
                id: 'nx-datastores-update',
                description: 'Update permission for data stores',
                type: 'application',
                properties: [
                    domain : 'datastores',
                    actions: 'update,read'
                ]
            ),
            new CPrivilege(
                id: 'nx-datastores-delete',
                description: 'Delete permission for data stores',
                type: 'application',
                properties: [
                    domain : 'datastores',
                    actions: 'delete,read'
                ]
            )
        ]
    )
  }
}
