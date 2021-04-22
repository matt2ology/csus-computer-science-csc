# Exercise16: S - Communicating Statistical Results

From [Cost-Effective Virtualized OLTP SQL Server Performance with HPE Persistent
Memory](https://www.hpe.com/lamerica/en/pdfViewer.html?docId=a00069717&parentPage=/lamerica/en/products/servers/persistent-memory-intel&resourceTitle=Cost-Effective+Virtualized+OLTP+SQL+Server+Performance+with+HPE+Persistent+Memory) on HPE's website

    "The same VM scaling and total performance increase can be achieved using
    all DRAM DDR4 with 128 GB DIMMs. However, cost analysis showed that the
    1.5 TB configuration with Intel Optane PMem 100 series for HPE had a 29%
    lesser memory cost than a configuration with 1.5 TB all-DRAM
    (not shown in the graph)"

This writing is effective at explaining the cost–benefit analysis of investing
in one type of memory technology over another; however, very often with
enterprise products/services, does read well to a general audience. If this
were to be written to a more general audience I would write it as:

    The same virtual machine scalability and total performance increase can
    be achieved by using conventional DDR4 128 GB RAM sticks; however,cost
    analysis showed that servers equipped with Intel 100 series Optane
    persistent memory HPE had a 29% reduction in computer memory cost than
    with a server equipped with 1.5 TB all dynamic random-access memory
    (DRAM) storage devices.
