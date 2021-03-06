package jenkins.plugins.mttr;

import hudson.Extension;
import hudson.model.Job;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import jenkins.plugins.util.ReadUtil;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

public class MTTRLast30DaysResultColumn extends ListViewColumn implements ResultColumn {

    @DataBoundConstructor
    public MTTRLast30DaysResultColumn() {
    }

    @Override
    public String getResult(Job job) throws IOException {
        return ReadUtil.getColumnResult(job, MetricsAction.MTTR_LAST_30_DAYS);
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        public DescriptorImpl() {
        }

        public String getDisplayName() {
            return Messages.last30DaysBuildsColumnTitle();
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }
}
