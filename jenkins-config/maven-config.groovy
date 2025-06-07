import hudson.model.*
import hudson.tasks.*
import hudson.tasks.Maven
import hudson.tools.*
import jenkins.model.*

import java.util.logging.Logger

def logger = Logger.getLogger("")
logger.info("Configuring Maven")

// Get Jenkins instance
def jenkins = Jenkins.getInstance()

// Define Maven installation
def mavenInstallation = new Maven.MavenInstallation("Maven", "/usr/share/maven", [])

// Get Maven tool descriptor
def mavenDescriptor = jenkins.getDescriptor(Maven.MavenInstallation.class)

// Add Maven installation
mavenDescriptor.setInstallations((Maven.MavenInstallation[]) [mavenInstallation])

// Save configuration
jenkins.save()

logger.info("Maven configuration completed")
