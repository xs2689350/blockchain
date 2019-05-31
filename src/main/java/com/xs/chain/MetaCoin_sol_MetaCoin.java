package com.xs.chain;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class MetaCoin_sol_MetaCoin extends Contract {
    private static final String BINARY = "60806040523480156200001157600080fd5b506040516200108b3803806200108b833981018060405260808110156200003757600080fd5b810190808051906020019092919080516401000000008111156200005a57600080fd5b828101905060208101848111156200007157600080fd5b81518560018202830111640100000000821117156200008f57600080fd5b5050929190602001805190602001909291908051640100000000811115620000b657600080fd5b82810190506020810184811115620000cd57600080fd5b8151856001820283011164010000000082111715620000eb57600080fd5b505092919050505083600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508360008190555082600390805190602001906200015692919062000195565b5081600460006101000a81548160ff021916908360ff16021790555080600590805190602001906200018a92919062000195565b505050505062000244565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620001d857805160ff191683800117855562000209565b8280016001018555821562000209579182015b8281111562000208578251825591602001919060010190620001eb565b5b5090506200021891906200021c565b5090565b6200024191905b808211156200023d57600081600090555060010162000223565b5090565b90565b610e3780620002546000396000f3fe608060405234801561001057600080fd5b50600436106100b45760003560e01c806336351c7c1161007157806336351c7c146102ac5780635c6581651461031257806370a082311461038a57806395d89b41146103e2578063dd62ed3e14610465578063fe99049a146104dd576100b4565b806306fdde03146100b9578063095bcdb61461013c578063095ea7b3146101ac57806318160ddd1461021257806327e235e314610230578063313ce56714610288575b600080fd5b6100c161056d565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101015780820151818401526020810190506100e6565b50505050905090810190601f16801561012e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101926004803603606081101561015257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919050505061060b565b604051808215151515815260200191505060405180910390f35b6101f8600480360360408110156101c257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610764565b604051808215151515815260200191505060405180910390f35b61021a610856565b6040518082815260200191505060405180910390f35b6102726004803603602081101561024657600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061085c565b6040518082815260200191505060405180910390f35b610290610874565b604051808260ff1660ff16815260200191505060405180910390f35b6102f8600480360360408110156102c257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610887565b604051808215151515815260200191505060405180910390f35b6103746004803603604081101561032857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506109de565b6040518082815260200191505060405180910390f35b6103cc600480360360208110156103a057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a03565b6040518082815260200191505060405180910390f35b6103ea610a4c565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561042a57808201518184015260208101905061040f565b50505050905090810190601f1680156104575780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6104c76004803603604081101561047b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610aea565b6040518082815260200191505060405180910390f35b610553600480360360808110156104f357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919080359060200190929190505050610b71565b604051808215151515815260200191505060405180910390f35b60038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106035780601f106105d857610100808354040283529160200191610603565b820191906000526020600020905b8154815290600101906020018083116105e657829003601f168201915b505050505081565b600081600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101561065957600080fd5b81600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550828473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f9ed053bb818ff08b8353cd46f78db1f0799f31c9e4458fdb425c10eccd2efc44856040518082815260200191505060405180910390a4600190509392505050565b600081600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925846040518082815260200191505060405180910390a36001905092915050565b60005481565b60016020528060005260406000206000915090505481565b600460009054906101000a900460ff1681565b600081600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410156108d557600080fd5b81600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f4ade20d82044693c0d3331ba1d2a482d103734f274166989491c8d30d3f2ecb1846040518082815260200191505060405180910390a36001905092915050565b6002602052816000526040600020602052806000526040600020600091509150505481565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ae25780601f10610ab757610100808354040283529160200191610ae2565b820191906000526020600020905b815481529060010190602001808311610ac557829003601f168201915b505050505081565b6000600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b600080600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905083600160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410158015610c425750838110155b610c4b57600080fd5b83600160008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254019250508190555083600160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825403925050819055507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff811015610d985783600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825403925050819055505b828573ffffffffffffffffffffffffffffffffffffffff168773ffffffffffffffffffffffffffffffffffffffff167f9ed053bb818ff08b8353cd46f78db1f0799f31c9e4458fdb425c10eccd2efc44876040518082815260200191505060405180910390a4600191505094935050505056fea165627a7a72305820019fe443e2b0a62f868ee14e67597baebacc5a81458d6b98cbb9261ee92845180029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_ALLOWED = "allowed";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RECHARGE_EVENT = new Event("Recharge", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MetaCoin_sol_MetaCoin(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MetaCoin_sol_MetaCoin(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MetaCoin_sol_MetaCoin(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MetaCoin_sol_MetaCoin(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger itemNo, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(itemNo), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> recharge(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowed(String param0, String param1) {
        final Function function = new Function(FUNC_ALLOWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value, BigInteger itemNo) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.generated.Uint256(itemNo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.itemNo = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.itemNo = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<RechargeEventResponse> getRechargeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECHARGE_EVENT, transactionReceipt);
        ArrayList<RechargeEventResponse> responses = new ArrayList<RechargeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RechargeEventResponse typedResponse = new RechargeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RechargeEventResponse> rechargeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RechargeEventResponse>() {
            @Override
            public RechargeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECHARGE_EVENT, log);
                RechargeEventResponse typedResponse = new RechargeEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RechargeEventResponse> rechargeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECHARGE_EVENT));
        return rechargeEventFlowable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    @Deprecated
    public static MetaCoin_sol_MetaCoin load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MetaCoin_sol_MetaCoin(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MetaCoin_sol_MetaCoin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MetaCoin_sol_MetaCoin(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MetaCoin_sol_MetaCoin load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MetaCoin_sol_MetaCoin(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MetaCoin_sol_MetaCoin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MetaCoin_sol_MetaCoin(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MetaCoin_sol_MetaCoin> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialAmount), 
                new org.web3j.abi.datatypes.Utf8String(_tokenName), 
                new org.web3j.abi.datatypes.generated.Uint8(_decimalUnits), 
                new org.web3j.abi.datatypes.Utf8String(_tokenSymbol)));
        return deployRemoteCall(MetaCoin_sol_MetaCoin.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MetaCoin_sol_MetaCoin> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialAmount), 
                new org.web3j.abi.datatypes.Utf8String(_tokenName), 
                new org.web3j.abi.datatypes.generated.Uint8(_decimalUnits), 
                new org.web3j.abi.datatypes.Utf8String(_tokenSymbol)));
        return deployRemoteCall(MetaCoin_sol_MetaCoin.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MetaCoin_sol_MetaCoin> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialAmount), 
                new org.web3j.abi.datatypes.Utf8String(_tokenName), 
                new org.web3j.abi.datatypes.generated.Uint8(_decimalUnits), 
                new org.web3j.abi.datatypes.Utf8String(_tokenSymbol)));
        return deployRemoteCall(MetaCoin_sol_MetaCoin.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MetaCoin_sol_MetaCoin> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_initialAmount), 
                new org.web3j.abi.datatypes.Utf8String(_tokenName), 
                new org.web3j.abi.datatypes.generated.Uint8(_decimalUnits), 
                new org.web3j.abi.datatypes.Utf8String(_tokenSymbol)));
        return deployRemoteCall(MetaCoin_sol_MetaCoin.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger itemNo;

        public BigInteger _value;
    }

    public static class RechargeEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _spender;

        public BigInteger _value;
    }
}
