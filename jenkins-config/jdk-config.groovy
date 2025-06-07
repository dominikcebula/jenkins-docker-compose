import hudson.model.*
import hudson.model.JDK
import hudson.tools.*
import jenkins.model.*

import java.util.logging.Logger

def logger = Logger.getLogger("")
logger.info("Configuring JDK")

// Get Jenkins instance
def jenkins = Jenkins.getInstance()

// Define JDK installation
def jdkInstallation = new JDK("JDK", "/opt/java/openjdk")

// Get JDK tool descriptor
def jdkDescriptor = jenkins.getDescriptor(JDK.class)

// Add JDK installation
jdkDescriptor.setInstallations((JDK[]) [jdkInstallation])

// Save configuration
jenkins.save()

logger.info("JDK configuration completed")
